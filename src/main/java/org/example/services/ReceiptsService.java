package org.example.services;

import org.example.utils.DateTimeUtil;
import org.example.utils.MoneyProcessingUtil;
import org.openapitools.model.Item;
import org.openapitools.model.Receipt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiptsService {
    private static final HashMap<UUID, Integer> RECEIPTS_AND_POINTS = new HashMap<>();
    private static final String FIRST_TIME = "14:00";
    private static final String SECOND_TIME = "16:00";
    private static final double ITEM_PRICE_MULTIPLIER = .20;
    private static final double QUARTER_MULTIPLE = .25;
    private static final int ROUND_DOLLAR_POINTS = 50;
    private static final int QUARTER_MULTIPLE_POINTS = 25;
    private static final int EVERY_TWO_ITEMS_POINTS = 5;
    private static final int ITEM_DESCRIPTION_MULTIPLE = 3;
    private static final int ODD_PURCHASE_DATES_POINTS = 6;
    private static final int PURCHASE_WINDOW_POINTS = 10;

    public UUID processReceipt(Receipt receipt) {
        int totalPoints = 0;

        String retailer = receipt.getRetailer();
        totalPoints += getAlphanumericalPoints(retailer);

        String total = receipt.getTotal();
        totalPoints += getRoundedDollarPoints(total);
        totalPoints += getMultipleOf25CentsPoints(total);

        List<Item> items = receipt.getItems();
        // Give points for every 2 items on the list. If there is a leftover of "1" items no points for that one
        totalPoints += items.size() / 2 * EVERY_TWO_ITEMS_POINTS;
        totalPoints += getItemDescriptionPoints(items);

        totalPoints += addPointsForPurchaseDay(receipt.getPurchaseDate());

        totalPoints += addPointsForPurchaseWindow(receipt.getPurchaseTime());

        UUID id = UUID.randomUUID();
        RECEIPTS_AND_POINTS.put(id, totalPoints);
        return id;
    }

    public long getPoints(UUID id) {
        return RECEIPTS_AND_POINTS.get(id);
    }


    // 1 point given for every alphanumerical character
    private static int getAlphanumericalPoints(String retailer) {
        int points = 0;
        for (int i = 0; i < retailer.length(); i++) {
            if (Character.isDigit(retailer.charAt(i)) || Character.isLetter(retailer.charAt(i))) {
                points++;
            }
        }
        return points;
    }

    // If we see a rounded dollar i.e. 1.00 (cents is 0) then add 50 points
    private static int getRoundedDollarPoints(String money) {
        double total = Double.parseDouble(money);
        int cents = MoneyProcessingUtil.getCents(total);
        return cents == 0 ? ROUND_DOLLAR_POINTS : 0;
    }

    // If the total dollar amount if a multiple of .25 then we add 25 points
    private static int getMultipleOf25CentsPoints(String money) {
        return Double.parseDouble(money) % QUARTER_MULTIPLE == 0 ? QUARTER_MULTIPLE_POINTS : 0;
    }

    // If trimmed length of item description is a multiple of ITEM_DESCRIPTION_MULTIPLE assign points
    private static int getItemDescriptionPoints(List<Item> items) {
        int points = 0;
        for (var item: items) {
            if (item.getShortDescription().trim().length() % ITEM_DESCRIPTION_MULTIPLE == 0) {
                int roundedUp = (int) Math.ceil(Double.parseDouble(item.getPrice()) * ITEM_PRICE_MULTIPLIER);
                points += roundedUp;
            }
        }
        return points;
    }

    // Add points if we have an odd day date
    private static int addPointsForPurchaseDay(LocalDate date) {
        // add points for odd days
        return DateTimeUtil.parseDayFromDate(date) % 2 != 0 ? ODD_PURCHASE_DATES_POINTS : 0;
    }

    // If purchased between our purchase window then add points
    private static int addPointsForPurchaseWindow(String time) {
        return DateTimeUtil.isBetweenTimes(FIRST_TIME, SECOND_TIME, time) ? PURCHASE_WINDOW_POINTS : 0;
    }
}

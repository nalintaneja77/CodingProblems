package dsamore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
from a list of reservation with days and price,
 given duration of promotion and size of reservation and bonus rate..
calculate the best day for promotion start and highest bonus
 */
public class Main {
    static void main() {
        List<Reservation> reservationList = List.of(
                new Reservation(1,100),
                new Reservation(2,200),
                new Reservation(3,150),
                new Reservation(4,300),
                new Reservation(5,400),
                new Reservation(6,500)

                );
        int promotionDays = 3;
        double bonusRate  = 10;


        double maxBonus = 0;
        int bestStartDay = -1;

        for(int i = 0;i<=reservationList.size()-promotionDays;i++)
        {
            double totalPrice  = 0;

            for(int j = i;j<i+promotionDays;j++)
            {
                totalPrice = totalPrice + reservationList.get(j).price();
            }

            double bonus = totalPrice * bonusRate/100;

            if(bonus>maxBonus)
            {
                maxBonus = bonus;
                bestStartDay = reservationList.get(i).day();
            }
        }

        System.out.println("Promotion start day"+bestStartDay);
        System.out.println("Highest Bonus"+maxBonus);

    }
}

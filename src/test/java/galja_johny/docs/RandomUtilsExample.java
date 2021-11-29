package galja_johny.docs;

import static galja_johny.utiles.RandomUtils.getRandomEmail;
import static galja_johny.utiles.RandomUtils.getRandomString;

public class RandomUtilsExample {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }
}

package com.kenhia.organized;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello get organized.");

        module4();
    }

    /* Variables, Data Types, and Math Operators */
    public static void module3() {
        int myVar;
        myVar = 50;
        System.out.println(myVar);

        int anotherVar = 100;
        System.out.println(anotherVar);

        myVar = anotherVar;
        System.out.println(myVar);

        anotherVar = 200;
        System.out.println("anotherVar " + anotherVar);
        System.out.println("myVar " + myVar);

        /* Primitive Types - Stored by-value */
        // Integer Types
        byte numberOfEnglishLetters = 26; // [-128:127]
        short feetInMile = 5283; // [-32768:32767]
        int milesToSun = 92960000; // [-2147483648:2147483647]
        long nationalDebt = 18100000000000L; //[-9223372036854775808:9223372036854775807]

        // Floating Point Types (IEEE 754 floating point standard)
        // http://bit.ly/psjavafp
        float milesInMarathon = 26.2f; // [1.4x10^-45:3.4x10^38] (signed, pos, neg, 0, NaN, infinity, neg infinity)
        double atomWidthInMeters = 0.0000000001d; // d is optional, double assumed [4.9x10^-324:1.7x10^308]

        // Character Type - Unicode character
        char regularU = 'U';
        char accentedU = '\u00DA'; // 'Ú'

        // Boolean Type
        boolean iLoveJava = true;
        System.out.println(iLoveJava);
    }

    /* Conditional Logic, Looping, and Arrays */
    public static void module4() {
        // Conditional assignment
        int v1 = 7;
        int v2 = 5;
        int vMax = v1 > v2 ? v1 : v2;
        System.out.println(vMax);

        float students = 30;
        float rooms = 4;
        float studentsPerRoom = rooms == 0.0f ? 0.0f : students / rooms;
        System.out.println(studentsPerRoom);

        if (v1 > v2)
            System.out.println("v1 is bigger");

        if (v1 == v2)
            System.out.println("v1 equal v2");
        else
            System.out.println("v1 not equal v2");

        // Logical operators
        int a = 20, b = 14, c = 5;
        if (a > b & b >= c) System.out.println("a is bigger than c");
        if (false | true) System.out.println("false OR true -> true");
        if (false ^ true) System.out.println("false XOR true -> true");
        if (!false) System.out.println("NOT false -> true");

        // Conditional logic operators
        // only execute right side if needed to determine the result
        if (true && true) System.out.println("true is still true.");
        if (true || false) System.out.println("and true OR false is still true as well.");

        rooms = 0;

        int students2 = 150;
        int rooms2 = 0;

        if (rooms2 > 0 && students2/rooms2 > 30) System.out.println("Crowded!");
        try {
            if (rooms > 0 & students2/rooms2 > 30) System.out.println("Crowded!");
        } catch (Exception e) {
            System.out.println("Caught exception...");
            System.out.println(e.getMessage());
        }

    }
}

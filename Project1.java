import java.util.Scanner;
import java.util.Arrays;

class Menu {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("Clear screen not supported.");
        }
    }
}

public class Project1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Menu.clearScreen();
            System.out.println("Main Menu:");
            System.out.println("1. Patterns");
            System.out.println("2. Strings");
            System.out.println("3. Array Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                patternOperations(sc);
            } else if (choice == 2) {
                stringOperations(sc);
            } else if (choice == 3) {
                arrayOperations(sc);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid input. Try again.");
                pause(sc);
            }
        }
        sc.close();
    }

    public static void pause(Scanner sc) {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    // ARRAY OPERATIONS 

    public static void arrayOperations(Scanner sc) {
        Menu.clearScreen();
        System.out.println("Array Operations:");
        System.out.println("1. Searching");
        System.out.println("2. Sorting");
        System.out.println("3. Deletion");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int arrayChoice = sc.nextInt();
        sc.nextLine();

        switch (arrayChoice) {
            case 1: arraySearch(sc); break;
            case 2: arraySorting(sc); break;
            case 3: arrayDeletion(sc); break;
            case 4: return;
            default: System.out.println("Invalid choice!");
        }
        pause(sc);
    }

    public static void arraySearch(Scanner sc) {
        Menu.clearScreen();
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found in the array.");
        }
    }

    public static void arraySorting(Scanner sc) {
        Menu.clearScreen();
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Menu.clearScreen();
        System.out.println("Sorting Menu:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Back to Array Menu");
        System.out.print("Enter your choice: ");
        int sortChoice = sc.nextInt();

        switch (sortChoice) {
            case 1: selectionSort(arr); break;
            case 2: bubbleSort(arr); break;
            case 3: insertionSort(arr); break;
            case 4: return;
            default: System.out.println("Invalid choice!");
        }

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void arrayDeletion(Scanner sc) {
        Menu.clearScreen();
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the index to delete: ");
        int index = sc.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        int[] newArr = new int[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }

        System.out.println("Array after deletion:");
        for (int num : newArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; j--;
            }
            arr[j + 1] = key;
        }
    }

    // ---------------- STRING OPERATIONS ----------------

    public static void stringOperations(Scanner sc) {
        Menu.clearScreen();
        System.out.println("String Operations:");
        System.out.println("1. Search for a substring");
        System.out.println("2. Sort characters in a string");
        System.out.println("3. Delete character at a specific position");
        System.out.println("4. Delete substring");
        System.out.println("5. Reverse a string");
        System.out.println("6. Uppercase");
        System.out.println("7. Lowercase");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: stringSearch(sc); break;
            case 2: stringSorting(sc); break;
            case 3: stringDeletion(sc); break;
            case 4: deleteSubstring(sc); break;
            case 5: reverseString(sc); break;
            case 6: convertToUppercase(sc); break;
            case 7: convertToLowercase(sc); break;
            case 8: return;
            default: System.out.println("Invalid choice!");
        }
        pause(sc);
    }

    public static void stringSearch(Scanner sc) {
        System.out.print("Enter the main string: ");
        String main = sc.nextLine();
        System.out.print("Enter the substring to search: ");
        String sub = sc.nextLine();
        if (main.contains(sub)) {
            System.out.println("Substring found at index: " + main.indexOf(sub));
        } else {
            System.out.println("Substring not found.");
        }
    }

    public static void stringSorting(Scanner sc) {
        System.out.print("Enter the string to sort: ");
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println("Sorted string: " + new String(chars));
    }

    public static void stringDeletion(Scanner sc) {
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.print("Enter the position to delete: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < str.length()) {
            String result = str.substring(0, index) + str.substring(index + 1);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid position.");
        }
    }

    public static void deleteSubstring(Scanner sc) {
        System.out.print("Enter the main string: ");
        String str = sc.nextLine();
        System.out.print("Enter substring to delete: ");
        String sub = sc.nextLine();
        System.out.println("Result: " + str.replace(sub, ""));
    }

    public static void reverseString(Scanner sc) {
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("Reversed: " + new StringBuilder(str).reverse());
    }

    public static void convertToUppercase(Scanner sc) {
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("Uppercase: " + str.toUpperCase());
    }

    public static void convertToLowercase(Scanner sc) {
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("Lowercase: " + str.toLowerCase());
    }

    // ---------------- PATTERN OPERATIONS ----------------

    public static void patternOperations(Scanner sc) {
        Menu.clearScreen();
        System.out.println("Pattern Operations:");
        System.out.println("1. Right Angle Triangle");
        System.out.println("2. Inverted Right Angled Triangle");
        System.out.println("3. Pyramid");
        System.out.println("4. Diamond");
        System.out.println("5. Hollow Square");
        System.out.println("6. Number Pyramid");
        System.out.println("7. Floyd's Triangle");
        System.out.println("8. Right Angled Triangle with Numbers");
        System.out.println("9. Hollow Pyramid");
        System.out.println("10. Inverted Pyramid");
        System.out.println("11. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice >= 1 && choice <= 10) {
            Menu.clearScreen();
            displayPattern(choice);
        }
        pause(sc);
    }

    public static void displayPattern(int n) {
        String[] patterns = {
            "Right-angled Triangle", "Inverted Right-angled Triangle", "Pyramid", "Diamond",
            "Hollow Square", "Number Pyramid", "Floyd's Triangle", "Right Angled with Numbers",
            "Hollow Pyramid", "Inverted Pyramid"
        };
        System.out.println("Pattern: " + patterns[n - 1]);
        switch (n) {
            case 1: for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) System.out.print("* "); System.out.println(); } break;
            case 2: for (int i = 5; i >= 1; i--) { for (int j = 1; j <= i; j++) System.out.print("* "); System.out.println(); } break;
            case 3: for (int i = 1; i <= 5; i++) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*"); System.out.println(); } break;
            case 4: for (int i = 1; i <= 5; i++) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*"); System.out.println(); } for (int i = 4; i >= 1; i--) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*"); System.out.println(); } break;
            case 5: for (int i = 1; i <= 5; i++) { for (int j = 1; j <= 5; j++) System.out.print((i == 1 || i == 5 || j == 1 || j == 5) ? "* " : "  "); System.out.println(); } break;
            case 6: for (int i = 1; i <= 5; i++) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= i; j++) System.out.print(j + " "); System.out.println(); } break;
            case 7: int num = 1; for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) System.out.print(num++ + " "); System.out.println(); } break;
            case 8: for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) System.out.print(j + " "); System.out.println(); } break;
            case 9: for (int i = 1; i <= 5; i++) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print((j == 1 || j == (2 * i - 1) || i == 5) ? "*" : " "); System.out.println(); } break;
            case 10: for (int i = 5; i >= 1; i--) { for (int j = 5; j > i; j--) System.out.print(" "); for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*"); System.out.println(); } break;
        }
    }
}

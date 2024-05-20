import java.util.Scanner;

class JuiceCentre {
    int Order_no;
    String Type_of_Juice;
    String Customer_Name;
    String customer_no;
    float Added_Sugar_Percentage;
    JuiceCentre next;

    public JuiceCentre(int Order_no, String Type_of_Juice, String Customer_Name, String customer_no, float Added_Sugar_Percentage) {
        this.Order_no = Order_no;
        this.Type_of_Juice = Type_of_Juice;
        this.Customer_Name = Customer_Name;
        this.customer_no = customer_no;
        this.Added_Sugar_Percentage = Added_Sugar_Percentage;
        this.next = null;
    }
}

public class JuiceCorner {
    static JuiceCentre head;

    public static void insert(int Order_no, String Type_of_Juice, String Customer_Name, String customer_no, float Added_Sugar_Percentage) {
        JuiceCentre juiceCentre = new JuiceCentre(Order_no, Type_of_Juice, Customer_Name, customer_no, Added_Sugar_Percentage);

        if (head == null) {
            head = juiceCentre;
        } else {
            juiceCentre.next = head;
            head = juiceCentre;
        }
    }

    public static void search(int Order_no) {
        JuiceCentre temp = head;
        while (temp != null) {
            if (temp.Order_no == Order_no) {
                System.out.println("Order_no: " + temp.Order_no);
                System.out.println("Type_of_Juice: " + temp.Type_of_Juice);
                System.out.println("Customer_Name: " + temp.Customer_Name);
                System.out.println("Customer_no: " + temp.customer_no);
                System.out.println("Added_Sugar_Percentage: " + temp.Added_Sugar_Percentage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("JuiceCentre with Order_no " + Order_no + " is not found !!!");
    }

    public static void update(int Order_no) {
        JuiceCentre temp = head;
        while (temp != null) {
            if (temp.Order_no == Order_no) {
                System.out.println("Record with Order_no " + Order_no + " Found !!!");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new Type_of_Juice: ");
                temp.Type_of_Juice = scanner.next();
                System.out.print("Enter new Customer_Name: ");
                temp.Customer_Name = scanner.next();
                System.out.print("Enter new Number: ");
                temp.customer_no = scanner.next();
                System.out.print("Enter new Added_Sugar_Percentage: ");
                temp.Added_Sugar_Percentage = scanner.nextFloat();
                System.out.println("Updation Successful!!!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("JuiceCentre with Order_no " + Order_no + " is not found !!!");
    }

    public static void delete(int Order_no) {
        JuiceCentre temp1 = head;
        JuiceCentre temp2 = head;

        while (temp1 != null) {
            if (temp1.Order_no == Order_no) {
                System.out.println("Record with Order_no " + Order_no + " Found !!!");

                if (temp1 == temp2) {
                    head = head.next;
                    temp1 = null;
                } else {
                    temp2.next = temp1.next;
                    temp1 = null;
                }

                System.out.println("Record Successfully Deleted !!!");
                return;
            }

            temp2 = temp1;
            temp1 = temp1.next;
        }

        System.out.println("JuiceCentre with Order_no " + Order_no + " is not found !!!");
    }

    public static void display() {
        JuiceCentre temp = head;
        while (temp != null) {
            System.out.println("Order_no: " + temp.Order_no);
            System.out.println("Type_of_Juice: " + temp.Type_of_Juice);
            System.out.println("Customer_Name: " + temp.Customer_Name);
            System.out.println("Customer_number: " + temp.customer_no);
            System.out.println("Added_Sugar_Percentage: " + temp.Added_Sugar_Percentage + "\n");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        head = null;
        int choice;
        int Order_no;
        String Type_of_Juice;
        String Customer_Name;
        String customer_no;
        float Added_Sugar_Percentage;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n\t\t\t\tLogin");
        System.out.println("\t\t\t*********************");
        System.out.print("\nEnter Username: ");
        String u = scanner.next();
        System.out.print("\nEnter your password: ");
        String p = scanner.next();

        if (u.equals("hamaad")) {
            if (p.equals("12345")) {
                System.out.println("\n!!!! LOGIN SUCCESSFUL !!!\n\nPress Enter to continue...");
            } else {
                System.out.println("\n\n\t\t!!! WRONG PASSWORD !!!");
            }
        } else {
            System.out.println("\n\n\t\t!!! INVALID USERNAME !!!");
        }
        scanner.nextLine(); // Consume the newline character

        scanner.nextLine(); // Wait for Enter key press

        if (u.equals("hamaad") && p.equals("12345")) {
            System.out.println("*********************************************");
            System.out.println("                JUICE CORNER                 ");
            System.out.println("*********************************************");

            System.out.println("Enter 1 to insert order and customer details");
            System.out.println("2 to search for order details of customer");
            System.out.println("3 to delete order details of customer");
            System.out.println("4 to update order details of customer");
            System.out.println("5 to display all order details of customer");
            System.out.println("Enter 0 to exit");

            do {
                System.out.print("\nEnter Choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Order_no: ");
                        Order_no = scanner.nextInt();
                        System.out.print("Enter Type_of_Juice: ");
                        Type_of_Juice = scanner.next();
                        System.out.print("Enter Customer_Name: ");
                        Customer_Name = scanner.next();
                        System.out.print("Enter customer_phone_no: ");
                        customer_no = scanner.next();
                        System.out.print("How much Sugar_Percentage you want to add: ");
                        Added_Sugar_Percentage = scanner.nextFloat();
                        insert(Order_no, Type_of_Juice, Customer_Name, customer_no, Added_Sugar_Percentage);
                        break;
                    case 2:
                        System.out.print("Enter Order_no to search: ");
                        Order_no = scanner.nextInt();
                        search(Order_no);
                        break;
                    case 3:
                        System.out.print("Enter Order_no to delete: ");
                        Order_no = scanner.nextInt();
                        delete(Order_no);
                        break;
                    case 4:
                        System.out.print("Enter Order_no to update: ");
                        Order_no = scanner.nextInt();
                        update(Order_no);
                        break;
                    case 0:
                        System.out.println("You are exiting now");
                        break;
                    case 5:
                        display();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }

            } while (choice != 0);
        }

        scanner.close();
    }
}

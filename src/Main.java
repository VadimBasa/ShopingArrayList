import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<String> products = new ArrayList<>();

    private static void printProducts() {
        System.out.println("Список покупок: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> actions = new ArrayList<>();

        actions.add("добавить");
        actions.add("показать");
        actions.add("удалить");
        while (true) {
            System.out.println("Выберите операцию:");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(i + 1 + ". " + actions.get(i));
            }
            String inputString = scanner.nextLine();

            if (inputString.equals("end")) {
                break;
            } else if (Integer.parseInt(inputString) > 3 || ((Integer.parseInt(inputString)) <= 0)) { //проверка условия корректности ввода чисел больше 0 и не больше длины массива
                System.out.println("Ошибка! Выберите операцию от 1 до " + actions.size());
                continue;
            } else if (Integer.parseInt(inputString) > 0 && Integer.parseInt(inputString) < 4) {
                int actionNumber = Integer.parseInt(inputString);
                switch (actionNumber) {
                    case 1:
                        System.out.println("Какую покупку хотите добавить?");
                        String inputProduct = scanner.nextLine();
                        products.add(inputProduct);
                        System.out.println("Итого в списке покупок: " + products.size());
                        break;
                    case 2:
                        printProducts();
                        break;
                    case 3:
                        printProducts();
                        String deleteProductPrint = null;
                        System.out.println("Какую хотите удалить? Введите номер или значение ");
                        String deleteProductStr = scanner.nextLine();
                        try {
                            if ((Integer.parseInt(deleteProductStr)) > 0 && (Integer.parseInt(deleteProductStr)) < products.size() + 1) {//products.size()
                                int deleteProduct = Integer.parseInt(deleteProductStr) - 1;
                                deleteProductPrint = products.get(deleteProduct);
                                products.remove(deleteProduct);
                            } else {
                                deleteProductPrint = deleteProductStr;
                                products.remove(deleteProductStr);
                            }
                        } catch (NumberFormatException e) {
                            deleteProductPrint = deleteProductStr;
                            products.remove(deleteProductStr);
                        }
                        System.out.println("Покупка " + deleteProductPrint + " удалена, список покупок: ");
                        for (int i = 0; i < products.size(); i++) {
                            System.out.println(i + 1 + ". " + products.get(i));
                        }
                        break;
                }
            }
        }
    }
}

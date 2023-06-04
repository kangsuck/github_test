public class Main {
    public static void main(String[] args) {
        public class People {

            private String name;
            private int age;
            //true = 남성, false = 여성
            private boolean milkHolic;
            private String[] items;

            public String Milklike() {
                String result;

                for (int i = 0; i < items.length; i++) {
                    if (items[i].equals("milk")) {
                        this.milkHolic = true;
                    }
                }

                if (milkHolic == false) {
                    if (age < 20) {
                        result = "Milk Hater Junior";
                    } else if (age >= 40) {
                        result = "Milk Hater Senior";
                    } else {
                        result = "Milk Hater";
                    }
                } else if (milkHolic == true) {
                    if (age < 20) {
                        result = "Milk Lover Junior";
                    } else if (age >= 40) {
                        result = "Milk Lover Senior";
                    } else {
                        result = "Milk Lover";
                    }
                } else {
                    result = "Unknown Gender";
                }

                return result;
            }

        }
    }
}
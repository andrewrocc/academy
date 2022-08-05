package by.academy.homework4;

class Body {

    private Heart heart;

    private Lungs lungs;

    public Body() {
        heart = new Heart();
        lungs = new Lungs();
    }

    public void live() {
        lungs.live();
        heart.live();
        System.out.println("You stand on the shore and feel the salty smell of the wind that blows from the sea. \n" +
                "And I believe that you are free, and life has only begun.\n");
    }

    class Heart {
        public void live() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if ((i % 100) == 0) {
                    System.out.print("Knock-knock-knockin' on heaven's door. ");
                }
            }
        }
    }

    class Lungs {
        public void live() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if ((i % 100) == 0) {
                    System.out.print("breathe out ");
                } else if ((i % 50) == 0) {
                    System.out.print("breathe in ");
                }
            }
        }
    }
}

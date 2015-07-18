package appewtc.masterung.testishihara;

/**
 * Created by masterUNG on 7/17/15 AD.
 */
public class MyValue {

    //Explicit
    private int controllerAnInt;

    public MyValue(int controllerAnInt) {
        this.controllerAnInt = controllerAnInt;
    }   // Constructor

    public int choiceValue() {

        int[] intTime = {R.array.times1, R.array.times2, R.array.times3, R.array.times4, R.array.times5,
                R.array.times6, R.array.times7, R.array.times8, R.array.times9, R.array.times10};
        return intTime[controllerAnInt];
    }

    public int ishiharaImage() {

        int[] intDrawable = {R.drawable.ishihara_01, R.drawable.ishihara_02, R.drawable.ishihara_03,
                R.drawable.ishihara_04, R.drawable.ishihara_05, R.drawable.ishihara_06, R.drawable.ishihara_07,
                R.drawable.ishihara_08, R.drawable.ishihara_09, R.drawable.ishihara_10};

        return intDrawable[controllerAnInt];
    }

    public String qurstionIshihara() {

        String[] strQuestion = {"1. What is this ?", "2. What is this ?", "3. What is this ?", "4. What is this ?",
                "5. What is this ?", "6. What is this ?", "7. What is this ?", "8. What is this ?", "9. What is this ?",
                "10. What is this ?"};

        return strQuestion[controllerAnInt];
    }

}   // Main Class

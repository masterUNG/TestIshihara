package appewtc.masterung.testishihara;

import android.content.Context;

/**
 * Created by masterUNG on 7/17/15 AD.
 */
public class MyValue {

    //Explicit
    private Context objContext;
    private int controllerAnInt;

    public MyValue(int controllerAnInt) {
        this.objContext = objContext;
        this.controllerAnInt = controllerAnInt;
    }   // Constructor

    public String qurstionIshihara() {

        String[] strQuestion = {"Zero", "One", "Two", "Three", "Four"};
        String strMyQuestion = strQuestion[controllerAnInt];

        return strMyQuestion;
    }

}   // Main Class

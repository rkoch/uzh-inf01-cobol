package ch.uzh.inf01.cobol.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ant {

    // Kruemel Hauffen Array
    private static Crumb[] mCrumbsPile;
    private List<Crumb>    mLoadedCrumbs;
    private float          mMaxLoad;

    public Ant() {
        mLoadedCrumbs = new ArrayList<Crumb>(); // Diamonds can be empty as of Java 7
        mMaxLoad = 30;
        Ant.litterCrumbs();
    }


    public Crumb[] getKruemelHaufen() {
        return mCrumbsPile;
    }


    public static void litterCrumbs() {
        Random r = new Random();
        mCrumbsPile = new Crumb[10];
        for (int i = 0; i < mCrumbsPile.length; i++) {
            float weight = r.nextInt(10) + 1;
            float calories = r.nextInt(10) + 1;
            mCrumbsPile[i] = new Crumb(weight, calories);
        }
    }


    public void sortPile() {
        // Task: sortiere diese Kruemel aufsteigend nach Verhaeltnis
        for (int indexSorter = 0; indexSorter < mCrumbsPile.length; indexSorter++) {

            for (int i = indexSorter; i < mCrumbsPile.length; i++) {

                if (mCrumbsPile[indexSorter].getRatio() < mCrumbsPile[i].getRatio()) {
                    swapCrumbs(indexSorter, i);
                }
                // after one iteration the biggest one is at the beginning
            }
        }
    }

    private void swapCrumbs(int pCrumb1, int pCrumb2) {
        Crumb temp = mCrumbsPile[pCrumb1];
        mCrumbsPile[pCrumb1] = mCrumbsPile[pCrumb2];
        mCrumbsPile[pCrumb2] = temp;
    }


    public List<Crumb> load() {
        sortPile();

        float sum = 0;
        mLoadedCrumbs.add(mCrumbsPile[0]);
        sum += mCrumbsPile[0].getWeight();

        for (int i = 1; i < mCrumbsPile.length; i++) {
            if (sum + mCrumbsPile[i].getWeight() <= mMaxLoad) {
                mLoadedCrumbs.add(mCrumbsPile[i]);
                sum += mCrumbsPile[i].getWeight();
            }
        }

        System.out.println("Lauf Ameise, lauf!");

        return mLoadedCrumbs;
    }

}

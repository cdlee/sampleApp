package android.com.sampleapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdlee on 8/11/17.
 */

public class ViewGroupings {
    public static final int DOWN = 1;
    public static final int ACROSS = 2;
    List<List<Integer>> downGroupings = new ArrayList<>();;
    List<List<Integer>>acrossGroupings = new ArrayList<>();;

    public void addGrouping(List<Integer> grouping, int direction) {
        if (direction == DOWN) {
            this.downGroupings.add(grouping);
        }else {
            this.acrossGroupings.add(grouping);
        }
    }
    public List<Integer> findGrouping(int pos, int direction) {
        List<Integer> grouping = new ArrayList<>();
        if (direction == DOWN) {
            for (int i = 0; i < downGroupings.size(); i++) {
                if (downGroupings.contains(pos)) {
                    grouping = downGroupings.get(i);
                }
            }
        } else {
            for (int j = 0; j < acrossGroupings.size(); j++) {
                if (acrossGroupings.get(j).contains(pos)) {
                    grouping = acrossGroupings.get(j);
                }
            }
        }
        return grouping;
    }
}

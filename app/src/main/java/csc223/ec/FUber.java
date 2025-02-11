package csc223.ec;

public class FUber {

    public static float euclidean(float x1, float y1, float x2, float y2) {
        float xDifference = x2-x1;
        float yDifference = y2-y1;

        xDifference *= xDifference;
        yDifference *= yDifference;

        float xPlusY = xDifference + yDifference;
        return (float) Math.sqrt(xPlusY);
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        float xDifference = x2-x1;
        float yDifference = y2-y1;

        float absX = Math.abs(xDifference);
        float absY = Math.abs(yDifference);

        return absX + absY;

    }
}

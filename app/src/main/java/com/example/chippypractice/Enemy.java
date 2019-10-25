package com.example.chippypractice;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.chippypractice.GameEngine.screenRatioX;
import static com.example.chippypractice.GameEngine.screenRatioY;

public class Enemy {

    public int speed = 10;
    public boolean wasShot = true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap bubble1, bubble2, bubble3, bubble4;

    Enemy(Resources res) {

        bubble1 = BitmapFactory.decodeResource(res, R.drawable.bubble1);
        bubble2 = BitmapFactory.decodeResource(res, R.drawable.bubble2);
        bubble3 = BitmapFactory.decodeResource(res, R.drawable.bubble3);
        bubble4 = BitmapFactory.decodeResource(res, R.drawable.bubble4);

        width = bubble1.getWidth();
        height = bubble1.getHeight();

        width /= 8;
        height /= 8;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        bubble1 = Bitmap.createScaledBitmap(bubble1, width, height, false);
        bubble2 = Bitmap.createScaledBitmap(bubble2, width, height, false);
        bubble3 = Bitmap.createScaledBitmap(bubble3, width, height, false);
        bubble4 = Bitmap.createScaledBitmap(bubble4, width, height, false);

        y = -height;
    }

    Bitmap getBird () {

        if (birdCounter == 1) {
            birdCounter++;
            return bubble1;
        }

        if (birdCounter == 2) {
            birdCounter++;
            return bubble2;
        }

        if (birdCounter == 3) {
            birdCounter++;
            return bubble3;
        }

        birdCounter = 1;

        return bubble4;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}
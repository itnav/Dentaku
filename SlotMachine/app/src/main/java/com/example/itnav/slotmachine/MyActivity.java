package com.example.itnav.slotmachine;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MyActivity extends Activity {
    int droidSide1 = -1;
    int droidSide2 = -1;
    int droidSide3 = -1;
    MediaPlayer mp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final ImageView droidImage1 = (ImageView) this
                .findViewById(R.id.droidimageid1);
        final ImageView droidImage2 = (ImageView) this
                .findViewById(R.id.droidimageid2);
        final ImageView droidImage3 = (ImageView) this
                .findViewById(R.id.droidimageid3);

        final Random r = new Random();

        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);
        final Button retryButton = (Button) this.findViewById(R.id.retrybutton);
         retryButton.setVisibility(View.INVISIBLE);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mp = MediaPlayer.create(getBaseContext(), R.raw.get_2);
                 mp.start();
                 mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                     @Override
                     public void onCompletion(MediaPlayer mp) {
                         mp.release();

                     }
                 });


                 droidSide1 = r.nextInt(4);
                 switch (droidSide1) {
                     case 0:
                         droidImage1.setImageResource(R.drawable.slot1);
                         break;
                     case 1:
                         droidImage1.setImageResource(R.drawable.slot2);
                         break;
                     case 2:
                         droidImage1.setImageResource(R.drawable.slot3);
                         break;
                     default:
                         droidImage1.setImageResource(R.drawable.slot4);
                 }
                 if (droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                     mp = MediaPlayer.create(getBaseContext(), R.raw.ooatari);
                     mp.start();
                     mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                         @Override
                         public void onCompletion(MediaPlayer mp) {
                             mp.release();

                         }
                     });





                     Toast.makeText(getApplicationContext(), "おめでとう！揃いました！",
                             Toast.LENGTH_SHORT).show();
                     retryButton.setVisibility(View.VISIBLE);



                 } else if (droidSide1 != -1 && droidSide2 != -1
                         && droidSide3 != -1) {
                     retryButton.setVisibility(View.VISIBLE);
                 }
                 v.setEnabled(false);
             }
         });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp = MediaPlayer.create(getBaseContext(), R.raw.get_2);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();

                    }
                });



                droidSide2 = r.nextInt(4);
                switch (droidSide2) {
                    case 0:
                        droidImage2.setImageResource(R.drawable.slot1);
                        break;
                    case 1:
                        droidImage2.setImageResource(R.drawable.slot2);
                        break;
                    case 2:
                        droidImage2.setImageResource(R.drawable.slot3);
                        break;
                    default:
                        droidImage2.setImageResource(R.drawable.slot4);
                }
                if (droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                    mp = MediaPlayer.create(getBaseContext(), R.raw.ooatari);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();

                        }
                    });

                    Toast.makeText(getApplicationContext(), "おめでとう！揃いました！",
                            Toast.LENGTH_SHORT).show();
                    retryButton.setVisibility(View.VISIBLE);
                } else if (droidSide1 != -1 && droidSide2 != -1
                        && droidSide3 != -1) {
                    retryButton.setVisibility(View.VISIBLE);
                }
                v.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp = MediaPlayer.create(getBaseContext(), R.raw.get_2);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();

                    }
                });

                droidSide3 = r.nextInt(4);
                switch (droidSide3) {
                    case 0:
                        droidImage3.setImageResource(R.drawable.slot1);
                        break;
                    case 1:
                        droidImage3.setImageResource(R.drawable.slot2);
                        break;
                    case 2:
                        droidImage3.setImageResource(R.drawable.slot3);
                        break;
                    default:
                        droidImage3.setImageResource(R.drawable.slot4);
                }
                if (droidSide1 == droidSide2 && droidSide1 == droidSide3) {
                    mp = MediaPlayer.create(getBaseContext(), R.raw.ooatari);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();

                        }
                    });

                    Toast.makeText(getApplicationContext(), "おめでとう！揃いました！",
                            Toast.LENGTH_SHORT).show();
                    retryButton.setVisibility(View.VISIBLE);
                } else if (droidSide1 != -1 && droidSide2 != -1
                        && droidSide3 != -1) {
                    retryButton.setVisibility(View.VISIBLE);
                }
                v.setEnabled(false);
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp = MediaPlayer.create(getBaseContext(), R.raw.menu_2);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();

                    }
                });



                ImageView img1 = (ImageView) findViewById(R.id.droidimageid1);
                RotateAnimation rotate1 = new RotateAnimation(0,360,img1.getWidth()/2, img1.getHeight()/2);
                rotate1.setDuration(400);
                img1.startAnimation(rotate1);
                ImageView img2 = (ImageView) findViewById(R.id.droidimageid2);
                RotateAnimation rotate2 = new RotateAnimation(0,360,img2.getWidth()/2, img2.getHeight()/2);
                rotate2.setDuration(500);
                img2.startAnimation(rotate2);
                ImageView img3 = (ImageView) findViewById(R.id.droidimageid3);
                RotateAnimation rotate3 = new RotateAnimation(0,360,img3.getWidth()/2, img3.getHeight()/2);
                rotate3.setDuration(600);
                img3.startAnimation(rotate3);

                droidImage1.setImageResource(R.drawable.star);
                droidImage2.setImageResource(R.drawable.star);
                droidImage3.setImageResource(R.drawable.star);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                retryButton.setVisibility(View.INVISIBLE);
                droidSide1 = droidSide2 = droidSide3 = -1;
            }
        });
        ;
    }





}
package me.hz89.retrofit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.hz89.retrofit.api.ExpressApiService;
import me.hz89.retrofit.db.Data;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.com)
    EditText com;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.reqest)
    Button reqest;
    public static final int UPDATE = 1;

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE:

//                    Data data = null;

//                    ExpressApiService.getInstace().result("shunfeng", "199383850438")
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Subscriber<Data>()
//                            {
//                                @Override
//                                public void onCompleted() {
//
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//
//                                }
//
//                                @Override
//                                public void onNext(Data data) {
//
//                                    String my = data.getNu();
//                                    String my1 = data.getState();
//                                    String data1 = data.getData().get(0).getContext();
//
//                                }
//                            });



                    Call<Data> dataCall = ExpressApiService.getInstace().result("shunfeng", "199383850438");
                    dataCall.enqueue(new retrofit2.Callback<Data>()
                    {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {

                            Data data = response.body();
                            String com = data.getCom();
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {

                        }
                    });

                    break;
                default:
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        reqest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable()
                {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = UPDATE;
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });

    }


}

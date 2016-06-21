# Retrofit
查询快递的接口，利用Retrofit
两种实现方法：
* 第一种


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


* 第二种

```
@GET("query")
Observable<Data> result(@Query("type") String company, @Query("postid") String number);

ExpressApiService.getInstace().result("shunfeng", "199383850438")
		.subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread())
		.subscribe(new Subscriber<Data>()
		{
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(Data data) {

				String my = data.getNu();
				String my1 = data.getState();
				String data1 = data.getData().get(0).getContext();

			}
		});
```

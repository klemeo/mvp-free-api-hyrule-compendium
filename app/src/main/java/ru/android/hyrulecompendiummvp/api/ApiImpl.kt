package ru.android.hyrulecompendiummvp.api

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiImpl : Api {

    companion object {
        const val CONNECTION_TIMEOUT: Long = 60L
        const val READ_TIMEOUT: Long = 60L
        const val WRITE_TIMEOUT: Long = 60L
    }

    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(
            httpLoggingInterceptor.apply {
                level = (HttpLoggingInterceptor.Level.BODY)
            }
        )
        .addInterceptor(OkHttpProfilerInterceptor())
        .build()

    private val mApi = Retrofit.Builder()
        .baseUrl("https://botw-compendium.herokuapp.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory
                .createWithScheduler(Schedulers.newThread())
        )
        .client(okHttpClient)
        .build()
        .create(HyruleApi::class.java)


    override fun getApi(): HyruleApi = mApi
}
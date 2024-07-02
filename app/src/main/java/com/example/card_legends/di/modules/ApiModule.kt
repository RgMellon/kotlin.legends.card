package com.example.card_legends.di.modules


import com.example.card_legends.repositories.BestPlayerRepository
import com.example.card_legends.repositories.MvpRepository
import com.example.card_legends.repositories.PlayerRepository
import com.example.card_legends.repositories.StageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.1.3:3000/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return  OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }


    @Provides
    @Singleton
    fun provideHttpLoggerInterceptor(): HttpLoggingInterceptor {
        return  HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @Singleton
    fun provideBestPlayerRepository(retrofit: Retrofit): BestPlayerRepository {
        return retrofit.create(BestPlayerRepository::class.java)
    }


    @Provides
    @Singleton
    fun providePlayerRepository(retrofit: Retrofit): PlayerRepository {
        return retrofit.create(PlayerRepository::class.java)
    }

    @Provides
    @Singleton
    fun stageRepository(retrofit: Retrofit): StageRepository {
        return retrofit.create(StageRepository::class.java)
    }


    @Provides
    @Singleton
    fun mvpRepository(retrofit: Retrofit): MvpRepository {
        return retrofit.create(MvpRepository::class.java)
    }

}
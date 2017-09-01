package com.natthawut.tamboon.ui.donation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import co.omise.android.TokenRequest
import com.natthawut.tamboon.remote.DonationResponse
import com.natthawut.tamboon.repository.TamboonRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DonationViewModel(val repository: TamboonRepository) : ViewModel() {

    val donateResponseLiveData = MutableLiveData<DonationResponse>()

    fun donate(tokenRequest: TokenRequest, amount: Int) {
        repository.donate(tokenRequest, amount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> donateResponseLiveData.value = result }
    }

}
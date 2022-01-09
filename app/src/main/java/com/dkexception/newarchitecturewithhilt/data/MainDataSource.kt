package com.dkexception.newarchitecturewithhilt.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MainDataSource @Inject constructor()

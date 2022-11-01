package com.cloudxanh.kointutorial.di

import org.koin.dsl.module


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */

// https://insert-koin.io/docs/reference/koin-android/start

val appModule = module {

}

val mvvmModule = module {

}

val scopeModule = module {

}

val scopeModuleActivityA = module {

}

val workerServiceModule = module {

}

val workerScopedModule = module {
}

val navModule = module {
}


// workerScopedModule can't be runned in unit test
val allModules = appModule + mvvmModule + scopeModule + workerServiceModule + workerScopedModule + navModule + scopeModuleActivityA

val allAlbumModule = listOf(repositoryModule, viewModelModule, retrofitModule, apiModule)

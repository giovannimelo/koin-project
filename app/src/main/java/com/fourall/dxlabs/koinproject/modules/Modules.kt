package com.fourall.dxlabs.koinproject.modules

import com.fourall.dxlabs.koinproject.repositories.ProductRepository
import com.fourall.dxlabs.koinproject.repositories.ProductRepositoryImpl
import com.fourall.dxlabs.koinproject.viewmodels.ProductViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * @see 'https://insert-koin.io/docs/1.0/getting-started/android-viewmodel/#injecting-dependencies'
 * @see 'https://insert-koin.io/docs/1.0/documentation/reference/index.html#_architecture_components_with_koin_viewmodel'
 */
val appModules = module {

    single<ProductRepository> { ProductRepositoryImpl() }
    viewModel { ProductViewModel(get()) }
}
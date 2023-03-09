//
//  MainAssembly.swift
//  SKFL-iOS
//

import Foundation
import shared
import Swinject

final class MainAssembly: Assembly {
    
    func assemble(container: Container) {
        container.register(MainViewController.self) { resolver in
            let viewModel = resolver.resolve(MainViewModel.self)
            return MainViewController(viewModel: viewModel)
        }
        
        container.register(MainViewModel.self) { _ in
            return IosMainDI().mainViewModel()
        }
    }
}

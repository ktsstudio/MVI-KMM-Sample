//
//  SwinjectManager.swift
//  iosApp
//

import Swinject
import UIKit
import shared

final class SwinjectManager {
    
    static let shared = SwinjectManager()
    
    private init() {}
    
    private let assembler = Assembler([
        MainAssembly()
    ])
    
    var mainVC: UIViewController? {
        guard let viewController = assembler.resolver.resolve(MainViewController.self)
        else { return nil }
        return UINavigationController(rootViewController: viewController)
    }
}

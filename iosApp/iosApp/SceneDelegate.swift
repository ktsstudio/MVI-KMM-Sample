//
//  SceneDelegate.swift
//  iosApp
//
//  Created by Елена Качармина on 09.03.2023.
//

import UIKit
import shared

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?


    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        KoinKt.doInitKoinIos()
        
        guard let windowScene = (scene as? UIWindowScene) else { return }

        guard let initialVC = SwinjectManager.shared.mainVC else { return }

        let window = UIWindow(windowScene: windowScene)
        window.rootViewController = initialVC
        self.window = window
        self.window?.backgroundColor = .white
        window.makeKeyAndVisible()
    }

    func sceneDidDisconnect(_ scene: UIScene) {
    }

    func sceneDidBecomeActive(_ scene: UIScene) {
    }

    func sceneWillResignActive(_ scene: UIScene) {
    }

    func sceneWillEnterForeground(_ scene: UIScene) {
    }

    func sceneDidEnterBackground(_ scene: UIScene) {
    }


}


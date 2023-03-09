//
//  ColorResourceExtension.swift
//  iosApp
//

import shared
import UIKit

extension ColorResource.Single {
    func getUIColor() -> UIColor {
        return self.getColor(userInterfaceStyle: .uiuserinterfacestylelight).toUIColor()
    }
}

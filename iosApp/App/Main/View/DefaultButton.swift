//
//  DefaultButton.swift
//  iosApp
//

import UIKit
import shared

class DefaultButton: UIButton {
    
    init(title: String) {
        super.init(frame: .zero)
        backgroundColor = MR.colors().buttonPrimaryActive.getUIColor()
        setTitle(title, for: .normal)
        setTitleColor(MR.colors().textPrimary.getUIColor(), for: .normal)
        titleLabel?.font = MR.fontsGilroy().medium.uiFont(withSize: 16)
        
        layer.cornerRadius = 8
        layer.masksToBounds = true
        titleLabel?.numberOfLines = 1
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}


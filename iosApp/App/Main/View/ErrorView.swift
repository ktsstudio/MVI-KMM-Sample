//
//  ErrorView.swift
//  iosApp
//

import UIKit
import SnapKit
import shared

final class ErrorView: UIView {
    
    private lazy var titleLabel: UILabel = {
        let outputLabel = UILabel()
        outputLabel.translatesAutoresizingMaskIntoConstraints = false
        outputLabel.numberOfLines = 0
        outputLabel.font = MR.fontsGilroy().medium.uiFont(withSize: 20)
        outputLabel.textColor = MR.colors().textSecondary.getUIColor()
        outputLabel.text = MR.strings().error_title.desc().localized()
        return outputLabel
    }()
    
    lazy var reloadButton: UIButton = {
        let outputView = DefaultButton(title: MR.strings().button_reload_title.desc().localized())
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    init() {
        super.init(frame: .zero)
        
        setupLayout()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupLayout() {
        [titleLabel,
         reloadButton].forEach { view in
            addSubview(view)
        }

        titleLabel.snp.makeConstraints { make in
            make.top.leading.trailing.equalToSuperview()
        }
        
        reloadButton.snp.makeConstraints { make in
            make.bottom.leading.trailing.equalToSuperview()
            make.top.equalTo(titleLabel.snp.bottom).offset(16)
        }
    }
}

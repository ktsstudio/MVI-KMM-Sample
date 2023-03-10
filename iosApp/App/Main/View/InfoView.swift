//
//  InfoView.swift
//  iosApp
//

import UIKit
import SnapKit
import shared

final class InfoView: UIView {
    private let title: String
    
    private lazy var titleLabel: UILabel = {
        let outputLabel = UILabel()
        outputLabel.translatesAutoresizingMaskIntoConstraints = false
        outputLabel.numberOfLines = 0
        outputLabel.font = MR.fontsGilroy().medium.uiFont(withSize: 16)
        outputLabel.textColor = MR.colors().textSecondary.getUIColor()
        outputLabel.text = title
        return outputLabel
    }()
    
    private lazy var infoLabel: UILabel = {
        let outputLabel = UILabel()
        outputLabel.translatesAutoresizingMaskIntoConstraints = false
        outputLabel.numberOfLines = 0
        outputLabel.font = MR.fontsGilroy().medium.uiFont(withSize: 16)
        outputLabel.textColor = MR.colors().textPrimary.getUIColor()
        return outputLabel
    }()
    
    private lazy var imageView: UIImageView = {
        let outputImageView = UIImageView()
        outputImageView.translatesAutoresizingMaskIntoConstraints = false
        outputImageView.contentMode = .scaleAspectFit
        return outputImageView
    }()
    
    init(title: String, type: InfoViewType) {
        self.title = title
        super.init(frame: .zero)
        
        setupLayout(type: type)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupLayout(type: InfoViewType) {
        addSubview(titleLabel)
        
        titleLabel.snp.makeConstraints { make in
            make.top.leading.trailing.equalToSuperview()
        }
        
        let secondView: UIView
        switch type {
        case .text:
            secondView = infoLabel
        case .image(let image):
            secondView = imageView
            imageView.image = image
        }
        addSubview(secondView)
        
        secondView.snp.makeConstraints { make in
            make.bottom.leading.equalToSuperview()
            make.top.equalTo(titleLabel.snp.bottom).offset(4)
            make.trailing.lessThanOrEqualToSuperview()
        }
    }
    
    func setText(_ text: String) {
        infoLabel.text = text
    }
    
    enum InfoViewType {
        case text, image(_ image: UIImage)
    }
}

//
//  MainView.swift
//  iosApp
//

import UIKit
import SnapKit
import shared

final class MainView: UIView {
    
    private lazy var containerView: UIView = {
        let outputView = UIView()
        outputView.translatesAutoresizingMaskIntoConstraints = false
        outputView.isHidden = true
        return outputView
    }()
    
    private lazy var stackView: UIStackView = {
        let outputView = UIStackView(frame: .zero)
        outputView.translatesAutoresizingMaskIntoConstraints = false
        outputView.axis = .vertical
        outputView.spacing = 8
        outputView.distribution = .fill
        return outputView
    }()
    
    private lazy var nameView: InfoView = {
        let outputView = InfoView(
            title: MR.strings().name_title.desc().localized(),
            type: .text
        )
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    private lazy var surnameView: InfoView = {
        let outputView = InfoView(
            title: MR.strings().surname_title.desc().localized(),
            type: .text
        )
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    private lazy var birthdayView: InfoView = {
        let outputView = InfoView(
            title: MR.strings().birthday_title.desc().localized(),
            type: .text
        )
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    private lazy var genderView: InfoView = {
        let outputView = InfoView(
            title: MR.strings().gender_title.desc().localized(),
            type: .text
        )
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    private lazy var deviceView: InfoView = {
        let outputView = InfoView(
            title: MR.strings().device_title.desc().localized(),
            type: .image(KImages.shared.image.ic_phone.withRenderingMode(.alwaysOriginal))
        )
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    lazy var loadButton: UIButton = {
        let outputView = DefaultButton(title: MR.strings().button_load_title.desc().localized())
        outputView.translatesAutoresizingMaskIntoConstraints = false
        return outputView
    }()
    
    lazy var errorView: ErrorView = {
        let outputView = ErrorView()
        outputView.translatesAutoresizingMaskIntoConstraints = false
        outputView.isHidden = true
        return outputView
    }()
    
    private lazy var loadingView: UIView = {
        let outputView = UIActivityIndicatorView(style: .large)
        outputView.translatesAutoresizingMaskIntoConstraints = false
        outputView.startAnimating()
        return outputView
    }()
    
    func setupLayout() {
        backgroundColor = .white
        addSubview(containerView)
        addSubview(errorView)
        addSubview(loadingView)
        containerView.addSubview(stackView)
        
        [nameView,
         surnameView,
         birthdayView,
         genderView,
         deviceView,
         loadButton].forEach { view in
            stackView.addArrangedSubview(view)
        }
        containerView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
        
        [stackView,
         errorView,
         loadingView].forEach { view in
            view.snp.makeConstraints { make in
                make.centerY.centerX.equalToSuperview()
            }
        }
    }
    
    private func setDetails(userInfo: UserInfo) {
        nameView.setText(userInfo.name)
        surnameView.setText(userInfo.surname)
        birthdayView.setText(userInfo.birthDay)
        genderView.setText(userInfo.gender)
        layoutIfNeeded()
    }
    
    enum State {
        case normal(userInfo: UserInfo), error, loading
    }
    
    func updateState(_ state: State) {
        switch state {
        case .normal(let userInfo):
            setDetails(userInfo: userInfo)
            errorView.isHidden = true
            loadingView.isHidden = true
            containerView.isHidden = false
        case .error:
            errorView.isHidden = false
            loadingView.isHidden = true
            containerView.isHidden = true
        case .loading:
            errorView.isHidden = true
            loadingView.isHidden = false
            containerView.isHidden = true
        }
    }
}

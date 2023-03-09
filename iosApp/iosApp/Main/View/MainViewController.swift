//
//  MainViewController.swift
//  SKFL-iOS
//

import UIKit
import shared
import RxSwift
import RxCocoa

final class MainViewController: UIViewController {
    
    private let mainView = MainView()
    private let viewModel: MainViewModel
    
    private let disposeBag = DisposeBag()
    
    init(viewModel: MainViewModel?) {
        guard let viewModel = viewModel
        else { fatalError("MainViewController init") }
        self.viewModel = viewModel
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("MainViewController.init(coder:) has not been implemented")
    }
    
    override func loadView() {
        view = mainView
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setup()
    }
    
    private func setup() {
        navigationItem.title = MR.strings().app_title.desc().localized()
        mainView.setupLayout()
        bindUI()
    }
    
    private func bindUI() {
        
        viewModel.state.subscribe { [weak self] state in
            guard let state = state, let self = self else { return }
            
            if state.error {
                self.mainView.updateState(.error)
            } else if state.loading {
                self.mainView.updateState(.loading)
            } else if let details = state.userInfo {
                self.mainView.updateState(.normal(userInfo: details))
            }
        }
        
        Observable.of(
            mainView.errorView.reloadButton.rx.tap,
            mainView.loadButton.rx.tap
        ).merge().subscribe(onNext: { [weak self] _ in
                self?.viewModel.load()
            }).disposed(by: disposeBag)
    }
}

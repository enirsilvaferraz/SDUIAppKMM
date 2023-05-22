import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
         Main_iosKt.InitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
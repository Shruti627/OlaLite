package Main;

import java.util.*;
import models.User;
import models.Ride;
import services.AuthService;
import services.BookingService;
import exceptions.InvalidLoginException;
import exceptions.BookingException;

public class Main {
	public static void main(String[] shruti) {
		Scanner sc = new Scanner(System.in);
		AuthService authService = new AuthService();
		BookingService bookingService = new BookingService();
		User currentUser = null;

		boolean exit = false;

		while (!exit) {
			if (currentUser == null || !currentUser.isLoggedIn()) {
				System.out.println("  ╔══════════════════════════════════════════╗");
				System.out.println("  ║    🚖 Welcome to OlaLite                 ║");
				System.out.println("  ╠══════════════════════════════════════════╣");
				System.out.println("  ║ 1. 📝 Sign Up                            ║");
				System.out.println("  ║ 2. 🔐 Log In                             ║");
				System.out.println("  ║ 3. ❌ Exit                               ║");
				System.out.println("  ║                                          ║");
				System.out.println("  ╚══════════════════════════════════════════╝");
				System.out.print("👉 Please Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.print("👤 Enter Name : ");
					String name = sc.nextLine();
					System.out.print("📧 Enter Email : ");
					String email = sc.nextLine();
					System.out.print("📱 Enter Mobile : ");
					String mobile = sc.nextLine();
					System.out.print("🔒 Enter Password : ");
					String password = sc.nextLine();
					authService.signUp(name, email, mobile, password);
					break;
				case 2:
					System.out.print("📧 Enter Email : ");
					String loginEmail = sc.nextLine();
					System.out.print("🔒 Enter Password : ");
					String loginPassword = sc.nextLine();
					try {
						currentUser = authService.login(loginEmail, loginPassword);
					} catch (InvalidLoginException e) {
						System.out.println("❌ " + e.getMessage());
					}
					break;
				case 3:
					System.out.println();
					System.out.println();
					System.out.println("---------👋 Thank you for using OlaLite. Have a great day!---------");
					System.exit(0);
					break;
				default:
					System.out.println("⚠️ Invalid choice. Please try again.");
				}
			} else {
				System.out.println("  ╔═════════════════════════════════╗");
				System.out.println("  ║     📱 OlaLite Dashboard        ║");
				System.out.println("  ╠═════════════════════════════════╣");
				System.out.println("  ║ 1. 🚕 Book a Ride               ║");
				System.out.println("  ║ 2. 📜 View Ride History         ║");
				System.out.println("  ║ 3. ⭐ Favorite Locations         ║");
				System.out.println("  ║ 4. 🔓 Logout                    ║");
				System.out.println("  ╚═════════════════════════════════╝");
				System.out.print("👉 Enter your choice: ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("--------------------------------------------");
					String pickup = "";
					String drop = "";

					// Pickup
					System.out.print("📍 Use Favorite for Pickup? (yes/no): ");
					if (sc.nextLine().equalsIgnoreCase("yes")) {
						List<String> favs = currentUser.getFavoriteLocations();
						if (favs.isEmpty()) {
							System.out.println("⚠️ No favorite locations found.");
							System.out.print("📍 Enter Pickup Location: ");
							pickup = sc.nextLine();
						} else {
							for (int i = 0; i < favs.size(); i++) {
								System.out.println((i + 1) + ". " + favs.get(i));
							}
							System.out.print("Choose number: ");
							int index = sc.nextInt();
							sc.nextLine();
							pickup = favs.get(index - 1);
						}
					} else {
						System.out.print("📍 Enter Pickup Location: ");
						pickup = sc.nextLine();
					}

					System.out.print("📍 Use Favorite for Drop? (yes/no): ");
					if (sc.nextLine().equalsIgnoreCase("yes")) {
						List<String> favs = currentUser.getFavoriteLocations();
						if (favs.isEmpty()) {
							System.out.println("⚠️ No favorite locations found.");
							System.out.print("📍 Enter Drop Location: ");
							drop = sc.nextLine();
						} else {
							for (int i = 0; i < favs.size(); i++) {
								System.out.println((i + 1) + ". " + favs.get(i));
							}
							System.out.print("Choose number: ");
							int index = sc.nextInt();
							sc.nextLine();
							drop = favs.get(index - 1);
						}
					} else {
						System.out.print("📍 Enter Drop Location: ");
						drop = sc.nextLine();
					}

					System.out.print("📏 Enter Distance (in km): ");
					double distance = sc.nextDouble();
					sc.nextLine();

					// 🚦 Simulate availability and ETA
					Random rand = new Random();
					int microAvailable = rand.nextInt(6); // 0–5 range
					int miniAvailable = rand.nextInt(6); /// 0-5
					int primeAvailable = rand.nextInt(6);

					int microEta = 2 + rand.nextInt(5); // 2–6 mins
					int miniEta = 4 + rand.nextInt(5); // 4–8 mins
					int primeEta = 5 + rand.nextInt(6); // 5–10 mins

					System.out.println("\n🚗 Available Cabs Nearby:");
					System.out.println("• Micro: " + microAvailable + " available | ETA: "
							+ (microAvailable > 0 ? microEta + " mins" : "N/A"));
					System.out.println("• Mini : " + miniAvailable + " available | ETA: "
							+ (miniAvailable > 0 ? miniEta + " mins" : "N/A"));
					System.out.println("• Prime: " + primeAvailable + " available | ETA: "
							+ (primeAvailable > 0 ? primeEta + " mins" : "N/A"));

					System.out.println("\n🚗 Choose Cab Type: Micro (10rs/km)/ Mini (15rs/km) / Prime (20rs/km)");
					String cabType = sc.nextLine().trim();

					// Availability Checkinhg
					boolean isAvailable = switch (cabType.toLowerCase()) {
					case "micro" -> microAvailable > 0;
					case "mini" -> miniAvailable > 0;
					case "prime" -> primeAvailable > 0;
					default -> false;
					};

					if (!isAvailable) {
						System.out.println("❌ Sorry, selected cab type is currently unavailable.");
						break;
					}

					System.out.println("\n╔═══════════════════════════════╗");
					System.out.println("║     🚕 Booking Confirmation   ║");
					System.out.println("╠═══════════════════════════════╣");
					System.out.println("║ Pickup: " + String.format("%-22s", pickup) + "║");
					System.out.println("║ Drop:   " + String.format("%-22s", drop) + "║");
					System.out.println("║ Cab:    " + String.format("%-22s", cabType) + "║");
					System.out.println("║ Dist:   " + String.format("%-5.2f km", distance) + "              ║");
					System.out.println("╚═══════════════════════════════╝");

					System.out.print("✅ Confirm booking? (yes/no): ");
					String confirm = sc.nextLine();

					if (confirm.equalsIgnoreCase("yes")) {
						try {
							Ride ride = bookingService.bookRide(currentUser.getEmail(), cabType, pickup, drop,
									distance);
							System.out.println("✅ Ride booked successfully!");
							ride.displayRide();
						} catch (BookingException e) {
							System.out.println("❌ Booking Failed: " + e.getMessage());
						}
					} else {
						System.out.println("❌ Booking cancelled by user.");
					}
					System.out.println("--------------------------------------------");

					break;

				case 2:
					List<Ride> rides = bookingService.getRideHistory(currentUser.getEmail());
					if (rides.isEmpty()) {
						System.out.println("ℹ️ No rides found.");
					} else {
						System.out.println("\n📜 Your Ride History:");
						for (Ride ride : rides) {
							System.out.println("╔════════════════════════════════════════════════╗");
							System.out.println("║              🚕 Ride Details                   ║");
							System.out.println("╠════════════════════════════════════════════════╣");
							System.out.println("║ 🆔 Ride ID     : " + String.format("%-30s", ride.getRideId()) + "║");
							System.out.println("║ 🚗 Cab Type    : " + String.format("%-30s", ride.getCabType()) + "║");
							System.out.println("║ 🛫 From        : " + String.format("%-30s", ride.getPickup()) + "║");
							System.out.println("║ 🛬 To          : " + String.format("%-30s", ride.getDrop()) + "║");
							System.out.println("║ 📏 Distance    : " + String.format("%-10.2fkm", ride.getDistance())
									+ "                  ║");
							System.out
									.println("║ 💰 Fare        : ₹" + String.format("%-28.2f", ride.getFare()) + " ║");
							System.out
									.println("║ ⏰ Time        : " + String.format("%-30s", ride.getTimestamp()) + "║");
							System.out.println("╚════════════════════════════════════════════════╝");
						}
					}
					break;

				case 4:
					authService.logout(currentUser);
					currentUser = null;
					System.out.println("🔓 Logged out successfully.");
					break;

				case 3:
					System.out.println("--------------------------------------------");
					System.out.println("⭐ Favorite Locations Menu");
					System.out.println("--------------------------------------------");
					System.out.println("1. ➕ Add Favorite Location");
					System.out.println("2. 📃 View Favorite Locations");
					System.out.println("--------------------------------------------");
					System.out.print("Choose an option: ");
					int favChoice = sc.nextInt();
					sc.nextLine();

					switch (favChoice) {
					case 1:
						System.out.print("📍 Enter location to add : ");
						String fav = sc.nextLine();
						currentUser.addFavoriteLocation(fav);
						System.out.println("✅ Location added to favorites!");
						System.out.println("--------------------------------------------");
						break;
					case 2:
						List<String> favs = currentUser.getFavoriteLocations();
						if (favs.isEmpty()) {
							System.out.println("ℹ️ No favorite locations saved.");
							System.out.println("--------------------------------------------");
						} else {
							System.out.println("📌 Favorite Locations:");
							for (int i = 0; i < favs.size(); i++) {
								System.out.println((i + 1) + ". " + favs.get(i));
							}
						}
						break;
					default:
						System.out.println("⚠️ Invalid option.");
					}
					break;

				default:
					System.out.println("⚠️ Invalid choice. Please try again.");
				}
			}
		}
	}
}

static int totalRuns(int[] batterSpeedLimits, int[][] pitchSpeeds) {
	int count = 0;
	// int j = 0;
	for (int i = 0; i < batterSpeedLimits.length; i++) {
		// if (j == pitchSpeeds.length) {
		// 	j = 0;
		// }
		for (int s = 0; s < 3; s++) {
			if (pitchSpeeds[j][s] <= batterSpeedLimits[i]) {
				count++;
				break;
			}
		}
		//j++;
	}
	return count > 3? count - 3 : 0;
}



static boolean canBeCaughted(int x， int y, int[][] position, int[] reach) {
	int gcd = gcd(x, y);
	x /= gcd;
	y /= gcd;

	if (x == 0) {
		x = 0;
		y = 1;a
	}

	for (int i = 0; i < position.length; i++) {
		int r = reach[i];
		int m = position[i][0]; //x
		int n = position[i][1]; //y

		for (int j = -r; j <= r; j++) {
			if (check(m + j, n, x, y) || check(m, n + j, x, y)) return true;
		}
	}
	return false;
}

static boolean check(int a, int b, int x, int y) {
	int g = gcd(a, b);
	a /= g;
	b /= g;
	if ((a == x) && (b == y)) return true;
	return false;
}


static int gcd(int a, int b) {
	if(b == 0) return a;
	return a % b == 0 ? b : gcd(b, a % b);
}
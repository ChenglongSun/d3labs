static int totalRuns(int[] batterSpeedLimits, int[][] pitchSpeeds) {
	int count = 0;
	int j = 0;
	for (int i = 0; i < batterSpeedLimits.length; i++) {
		if (j == pitchSpeeds.length) {
			j = 0;
		}
		for (int s = 0; s < 3; s++) {
			if (pitchSpeeds[j][s] <= batterSpeedLimits[i]) count++;
		}
		j++;
	}
	return count > 3? count - 3 : 0;
}
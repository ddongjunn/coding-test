class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = timeToSeconds(video_len);
        int currentPos = timeToSeconds(pos);
        int openingStart = timeToSeconds(op_start);
        int openingEnd = timeToSeconds(op_end);

        currentPos = skipOpening(currentPos, openingStart, openingEnd);

        for (String command : commands) {
            currentPos = processCommand(command, currentPos, videoLength);
            currentPos = skipOpening(currentPos, openingStart, openingEnd);
        }

        return secondsToTime(currentPos);
    }

    public int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public int skipOpening(int pos, int opStart, int opEnd) {
        if(opStart <= pos && pos <= opEnd) {
            return opEnd;
        }
        return pos;
    }

    public int processCommand(String command, int pos, int videoLen) {
        return switch (command) {
            case "prev" -> Math.max(pos - 10, 0);
            case "next" -> Math.min(pos + 10, videoLen);
            default -> pos;
        };
    }

    public String secondsToTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> datas = Arrays.stream(data)
            .map(d -> new Data(d[0], d[1], d[2], d[3]))
            .collect(Collectors.toList());

        List<Data> filtereDatas = datas.stream()
            .filter(d -> {
                switch (ext) {
                    case "code": return d.getCode() < val_ext;
                    case "date": return d.getDate() < val_ext;
                    case "maximum": return d.getMaximum() < val_ext;
                    case "remain": return d.getRemain() < val_ext;
                    default: return false;
                }
            }).collect(Collectors.toList());

        Comparator<Data> comparator;
        switch (sort_by) {
            case "code":
                comparator = Comparator.comparingInt(Data::getCode);
                break;
            case "date":
                comparator = Comparator.comparingInt(Data::getDate);
                break;
            case "maximum":
                comparator = Comparator.comparingInt(Data::getMaximum);
                break;
            case "remain":
                comparator = Comparator.comparingInt(Data::getRemain);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return filtereDatas.stream()
            .sorted(comparator)
            .map(d -> new int[]{d.getCode(), d.getDate(), d.getMaximum(), d.getRemain()})
            .toArray(int[][]::new);
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;

    Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }

    public int getCode() {
        return code;
    }

    public int getDate() {
        return date;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getRemain() {
        return remain;
    }
}
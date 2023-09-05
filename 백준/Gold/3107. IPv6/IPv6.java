import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (str.charAt(str.length() - 1) == ':') {
            str += "0";
        }

        String[] strArr = str.split(":");

        if (strArr[0].isEmpty()) {
            strArr[0] = "0000";
        }

        if (strArr[strArr.length - 1].isEmpty()) {
            strArr[strArr.length - 1] = "0000";
        }



        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < strArr.length - 1; i++) {

            if (strArr[i].isEmpty()) {
                sb.append("0000:".repeat(Math.max(0, 8 - (strArr.length - 1))));
            }else if(strArr[i].length() != 4) {
                while (strArr[i].length() != 4) {
                    strArr[i] = "0" + strArr[i];
                }
                sb.append(strArr[i]).append(":");

            }else {
                    sb.append(strArr[i]).append(":");
            }
        }

        while (strArr[strArr.length - 1].length() != 4) {
            strArr[strArr.length - 1] = "0" + strArr[strArr.length - 1];
        }
        sb.append(strArr[strArr.length - 1]);

        System.out.println(sb);
    }
}

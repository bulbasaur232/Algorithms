package greedy;

import java.io.*;
import java.util.*;

public class BOJ_2875 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int girls = Integer.parseInt(strings[0]); // 여학생 수
        int boys = Integer.parseInt(strings[1]); // 남학생 수
        int internship = Integer.parseInt(strings[2]); // 인턴십 참가 학생 수

        int pairs = ((girls / 2) < boys) ? girls / 2 : boys; // 일단 가능한 팀 갯수
        int remains = (girls - pairs * 2) + (boys - pairs); // 팀짜고 남는 학생 수

        internship = internship - remains; // 남는 학생들 인턴십 보낸다고 생각함

        double breakUp = 0; // 해체할 팀 수
        if(internship > 0){
            breakUp = Math.ceil((double)internship / 3); // 1명만 빠져도 팀이 해체되므로 3명으로 나눠서 올림처리 해줌
        }
        System.out.println((int)(pairs - breakUp));
        sc.close();
    }
}

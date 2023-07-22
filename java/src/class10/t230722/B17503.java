package class10.t230722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Beer[] beers = new Beer[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int preference = Integer.parseInt(st.nextToken());
            int dosu = Integer.parseInt(st.nextToken());

            beers[i] = new Beer(preference, dosu);
        }

        Arrays.sort(beers, Comparator.comparingInt(o -> o.dosu));
        PriorityQueue<Beer> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.preference));

        int preference = 0;
        for (int i = 0; i < K; i++) {
            if (pq.size() < N){
                pq.add(beers[i]);
                preference += beers[i].preference;
            }
            else if (preference < M){
                Beer pop = pq.poll();
                preference -= pop.preference;

                pq.add(beers[i]);
                preference += beers[i].preference;
            }
            else {
                break;
            }
        }

        if (preference < M){
            System.out.println(-1);
        } else {
            int river = 0;
            while (!pq.isEmpty()){
                Beer beer = pq.poll();
                if (river < beer.dosu){
                    river = beer.dosu;
                }
            }
            System.out.println(river);
        }
    }

    static class Beer {
        int preference;
        int dosu;

        public Beer(int preference, int dosu) {
            this.preference = preference;
            this.dosu = dosu;
        }
    }
}

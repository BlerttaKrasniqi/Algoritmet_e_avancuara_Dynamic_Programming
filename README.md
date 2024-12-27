# Programimi dinamik
## Përshkrimi i Problemit
Ky problem trajton ndarjen e një vargu topash të bardhë dhe të zinj. Vargu i topave duket si më poshtë:
•	Në fillim janë balls[0] topa të bardhë
•	Pas tyre janë balls[1] topa të zinj.
•	Më pas janë balls[2] topa të bardhë, dhe kështu me radhë, duke alternuar mes topave të bardhë dhe të zinj.
Objektivi është të ndajmë vargun në segmente, ku çdo segment etiketohet si "i bardhë" ose "i zi":
•	Një segment "i bardhë" duhet të përmbajë saktësisht white topa të bardhë dhe një numër të çfarëdoshëm topash të zinj.
•	Një segment "i zi" duhet të përmbajë saktësisht black topa të zinj dhe një numër të çfarëdoshëm topash të bardhë.
Qëllimi është të gjenden të gjitha mënyrat e mundshme për të ndarë vargun në segmente dhe për t'u dhënë etiketa.

## Shembuj
Input: {2, 2}, 1, 2
Output: 4
•	Ndarjet janë:
o	Segmenti i bardhë W, segmenti i bardhë W, segmenti i zi BB.
o	Segmenti i bardhë W, segmenti i bardhë WBB.
o	Segmenti i bardhë W, segmenti i zi WBB.
o	Segmenti i zi WWBB.


## Kërkesa
Për zgjidhjen e këtij problemi, kërkohen dy qasje të ndryshme, që kanë kompleksitet kohor dhe hapsinor të ndryshëm. Duhet të theksohet se njëra prej qasjeve për zgjidhjen e problemit duhet të përmbaj programim dinamik.

## Përshkrimi i Kodit
Ky kod implementon një zgjidhje për problemin e ndarjes së topave duke përdorur Programim Dinamik. 
Hapat Kryesorë të Implementimit
1.	Transformimi i Vargut
Vargu balls përfaqëson topat . Ky varg shndërrohet në një varg row, që  përmban vlerat 1 për të topa bardhë, 0 për topa të zinj.

<img width="371" alt="foto 1" src="https://github.com/user-attachments/assets/68c06140-69d2-4f47-88b4-57795e3a8e9a" />

2.	Inicimi i DP:
•	Një varg dp përdoret për të ruajtur numrin e mënyrave për të ndarë vargun deri në indeksin iii.
•	dp[0]dp[0]dp[0] inicializohet me 1, pasi ka vetëm një mënyrë për të trajtuar një varg bosh.
<img width="186" alt="Screenshot 2024-12-27 142504" src="https://github.com/user-attachments/assets/4e22d791-e97a-49b7-b736-f498a9f44a1f" />

3. Përpunimi i DP:
•	Për çdo indeks iii, algoritmi kontrollon të gjitha ndarjet e mundshme duke ecur mbrapa nga iii.
•	Për çdo ndarje, llogaritet numri i topave të bardhë dhe të zinj në segmentin aktual. Nëse një segment përputhet me kushtet e një segmenti të bardhë ose të zi, vlera e dp[i]dp[i]dp[i] përditësohet duke shtuar dp[j−1]dp[j-1]dp[j−1].
<img width="359" alt="foto3" src="https://github.com/user-attachments/assets/fd59b96a-2d0e-4793-8bb6-3d0b8bd3a904" />

4. Rezultati Final:
•	Rezultati ruhet në dp[n]dp[n]dp[n], ku nnn është gjatësia totale e vargut të topave.
•	FOTO



## Kompleksiteti kohor
1.	Rreshti (row):
-	Krijimi i array row që përfaqëson topat të bardhë dhe të zinj kërkon O(n)  ku n është numri total i topave (n=sum(balls))
2.	Unaza Kryesore:
-	Unaza e jashtme kalon O(n) herë.
-	Për çdo iteracion të ciklit të jashtëm, cikli i brendshëm përpunon deri në iii elemente, që prodhon një kompleksitet të përgjithshëm O(n^2) për të dy ciklet së bashku.

## Kompleksiteti Total Kohor:
•	O(n^2)


## Kompleksiteti hapsinor
1.	Array row:
-	Ruajtja e topave kërkon hapësirë O(n)
2.	Array dp:
-	Kërkon hapësirë O(n) për ruajtjen e rezultateve të ndërmjetme.

## Kompleksiteti Total Hapësinor:
•	O(n)





## Përshkrimi i Kodit
Ky kod përdor një qasje të bazuar në rekursion me memoizim për të gjetur numrin e mënyrave për të ndarë vargun e topave sipas kushteve të përcaktuara.

## Hapat kryesor të implementimit
1.	Transformimi i Vargut 
o	Ashtu si në qasjen e parë, vargu balls konvertohet në një varg row, ku çdo top përfaqësohet si 1 për të bardhët dhe 0 për të zinjtë.
2.	Funksioni simulate:
o	Ky funksion simulon ndarjen e vargut duke përdorur një qasje greedy.
o	Numëron segmentet "të bardhë" dhe "të zi" në mënyrë të njëpasnjëshme, duke përdorur një unazë për të llogaritur dhe kaluar në segmentin tjetër.
3.	Numërimi i Segmentimeve:
o	Për çdo segment, kontrollohet nëse plotësohet kushti për të bardhët ose për të zinjtë. Nëse plotësohet, shtohet në numrin total të mënyrave dhe vazhdohet me segmentin tjetër.
4.	Rezultati Final:
o	Rezultati i llogaritur nga simulate kthehet si numri total i mënyrave për ndarjen e vargut.

## Kompleksiteti kohor
1.	Rreshti (row):
-	Krijimi i array row kërkon O(n) njësoj si në qasjen dinamike.
2.	Simulimi (simulate):
-	Algoritmi kalon linearisht nëpër elementet e row për të numëruar topat e bardhë dhe të zinj në segmente të ndryshme.
-	Çdo element vizitohet një ose dy herë në total.
-	Kompleksiteti i simulate është O(n)

## Kompleksiteti Total Kohor:
•	O(n)

## Kompleksiteti hapsinor
1.	Array row:
o	Kërkon hapësirë O(n) për ruajtjen e topave.
2.	Stack Rekursioni:
o	Në këtë qasje nuk përdoret rekursion i thellë, dhe për këtë arsye nuk ka hapësirë shtesë të ndjeshme për call stack.

## Kompleksiteti Total Hapësinor:
•	O(n)



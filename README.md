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
-	Segmenti i bardhë W, segmenti i bardhë W, segmenti i zi BB.  
-	Segmenti i bardhë W, segmenti i bardhë WBB.  
-	Segmenti i bardhë W, segmenti i zi WBB.  
-	Segmenti i zi WWBB.  


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
•	dp[0]inicializohet me 1, pasi ka vetëm një mënyrë për të trajtuar një varg bosh.  
<img width="186" alt="Screenshot 2024-12-27 142504" src="https://github.com/user-attachments/assets/4e22d791-e97a-49b7-b736-f498a9f44a1f" />

3. Përpunimi i DP:  
•	Për çdo indeks iii, algoritmi kontrollon të gjitha ndarjet e mundshme duke ecur mbrapa nga iii.  
•	Për çdo ndarje, llogaritet numri i topave të bardhë dhe të zinj në segmentin aktual. Nëse një segment përputhet me kushtet e një segmenti të bardhë ose të zi, vlera e dp[i] përditësohet duke shtuar dp[j−1].  
<img width="359" alt="foto3" src="https://github.com/user-attachments/assets/fd59b96a-2d0e-4793-8bb6-3d0b8bd3a904" />

4. Rezultati Final:  
•	Rezultati ruhet në dp[n], ku nnn është gjatësia totale e vargut të topave.




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
Ky kod përdor një qasje të thjeshtë rekursive (brute force) për të gjetur numrin e mënyrave për të ndarë një varg topash sipas kushteve të dhëna për numrin e topave të bardhë dhe të zinj në çdo ndarje. Ai së pari transformon vargun balls në një përfaqësim linear të vargut të topave dhe pastaj përdor një funksion ndihmës për të eksploruar të gjitha ndarjet e mundshme.  

## Hapat kryesor të implementimit
1.	Transformimi i Vargut     
-Në funksionin countWaysBruteForce, vargu balls që përfaqëson grupet e topave të bardhë dhe të zinj konvertohet në një varg linear row ku çdo element përfaqëson një top (1 për të bardhët dhe 0 për të zinjtë).  
-Ky transformim bëhet duke alternuar mes 1 dhe 0 për secilin grup në balls.  

2.	Funksioni countWaysHelper:  
-	Ky funksion implementon logjikën rekursive për të gjetur numrin e ndarjeve të mundshme.  
-Rasti Bazë: Nëse indeksi start arrin fundin e vargut, konsiderohet se është gjetur një ndarje valide, dhe funksioni kthen 1.  
-Procesi Rekursiv: Për çdo segment të filluar nga start, llogariten numrat e topave të bardhë dhe të zinj. Nëse plotësohet një nga kushtet për një segment të vlefshëm, funksioni thirret për pjesën tjetër të vargut.   
<img width="525" alt="Screenshot 2024-12-29 at 16 40 22" src="https://github.com/user-attachments/assets/ef4ad522-0cb8-4850-a1eb-6727fc54471c" />    
  
3.	Numërimi i Segmentimeve:  
-	Funksioni iteron nëpër çdo pozicion të vargut duke ndarë segmentet sipas kufizimeve për numrin e topave të bardhë (white) dhe të zinj (black).  
-Rezultatet e ndarjeve të vlefshme grumbullohen dhe kthehen.  
4.	Rezultati Final:  
-	Në funksionin main, krijohen raste testuese për të llogaritur ndarjet për vlera të ndryshme të balls, white, dhe black.    

## Kompleksiteti kohor
Kompleksiteti kohor i funksionit countWaysBruteForce varet kryesisht nga thirrjet rekursive të bëra në funksionin countWaysHelper. Në rastin më të keq, funksioni eksploron të gjitha ndarjet e mundshme të vargut row. Duke qenë se gjatësia e vargut është n, numri i mënyrave për ta ndarë vargun në segmente mund të rritet në mënyrë eksponenciale. Konkretisht, për çdo pozicion në varg, funksioni mund të zgjedhë të mbyllë një segment ose të vazhdojë, duke krijuar një faktor degëzimi që mund të rezultojë në O(2^n) thirrje rekursive. Prandaj, kompleksiteti kohor i përgjithshëm mund të përafrohet si O(2^n), ku n është numri total i topave.   
<img width="494" alt="Screenshot 2024-12-29 at 16 41 53" src="https://github.com/user-attachments/assets/a0241442-1a39-46ff-b369-73f5f60e5210" />

## Kompleksiteti hapsinor
Kompleksiteti hapësinor përcaktohet nga hapësira e përdorur për stack-un e rekursioneve. Në rastin më të keq, thellësia maksimale e rekursionit mund të arrijë deri në n, duke çuar në një kompleksitet hapësinor prej O(n). Përveç kësaj, hapësira e përdorur për vargun row është gjithashtu O(n), pasi ruan përfaqësimin e plotë të topave. Prandaj, kompleksiteti i përgjithshëm hapësinor është O(n).    

## Përmbledhje e Kompleksitetit:
•	Kompleksiteti Kohor: O(2^n)
•	Kompleksiteti Hapësinor: O(n)  



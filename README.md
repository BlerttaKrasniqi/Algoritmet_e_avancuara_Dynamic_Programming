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
Ky kod përdor një qasje të bazuar në rekursion me memoizim për të gjetur numrin e mënyrave për të ndarë vargun e topave sipas kushteve të përcaktuara.

## Hapat kryesor të implementimit
1.	Transformimi i Vargut   
-	Vargu balls përfaqëson grupet e topave ku secili element tregon numrin e topave në secilin grup, duke alternuar midis të bardhëve (1) dhe të zinjve (0).
-	Ky varg transformohet në një varg linear row, ku çdo element është ose 1 (për topat e bardhë) ose 0 (për topat e zinj).  
<img width="425" alt="Screenshot 2024-12-29 at 14 58 38" src="https://github.com/user-attachments/assets/2327f490-a3f3-44d8-8e17-d1efc337f285" />

2.	Funksioni simulate:  
-	Ky funksion gjen numrin e ndarjeve të mundshme duke kontrolluar segmentet e vargut row.  
-	Fillon nga një indeks specifik dhe llogarit në mënyrë të vazhdueshme numrin e topave të bardhë (whiteCount) dhe të zinj (blackCount).Nëse plotësohet numri i kërkuar i topave të bardhë ose të zinj për një ndarje, funksioni thirret rekursivisht për pjesën tjetër të vargut.
<img width="523" alt="Screenshot 2024-12-29 at 15 03 01" src="https://github.com/user-attachments/assets/9310dc9d-51ec-4990-b7b7-13d90d67a48d" />
  
3.	Numërimi i Segmentimeve:  
-	Funksioni iteron nëpër të gjithë elementët e vargut row duke përdorur një cikël for dhe kontrollon për ndarjet e mundshme bazuar në kushtet për topat e bardhë dhe të zinj.  
4.	Rezultati Final:  
-	Rezultati i llogaritur nga simulate kthehet si numri total i mënyrave për ndarjen e vargut.  

## Kompleksiteti kohor
Funksioni count_ways krijon një varg row me madhësi n, ku n është numri total i topave. Ky operacion kërkon kohë O(n).  

Funksioni rekursiv simulate iteron nëpër vargun row dhe, për çdo pozicion, mund të thërrasë veten në mënyrë rekursive. Në rastin më të keq, kjo mund të çojë në një faktor degëzimi O(n) për çdo thirrje rekursive, duke rezultuar në kompleksitet O(n^2) në mungesë të memoizimit.  

Megjithatë, memoizimi përdoret për të ruajtur rezultatet e gjendjeve të llogaritura më parë, duke reduktuar ndjeshëm numrin e llogaritjeve të panevojshme. Numri i gjendjeve unike përcaktohet nga kombinimi i start dhe black, duke çuar në maksimum O(n * b) gjendje unike, ku b është numri maksimal i topave të zinj.  

Prandaj, kompleksiteti total kohor përafrohet në O(n * b), ku n është numri total i topave dhe b është numri maksimal i topave të zinj.   

## Kompleksiteti hapsinor
Kompleksiteti hapësinor ndikohet nga hapësira e përdorur për memoizimin. Harta store mund të përmbajë deri në O(n * b) gjendje, që korrespondon me gjendjet unike të funksionit rekursiv.  

Për më tepër, call stack i funksionit rekursiv mund të arrijë një thellësi maksimale prej O(n) në rastin më të keq, duke çuar në një hapësirë shtesë prej O(n).  

Prandaj, kompleksiteti total hapësinor është O(n * b) për shkak të ruajtjes së memoizimit, plus O(n) për call stack, që mund të thjeshtohet në O(n * b) si faktori dominues.   

## Përmbledhje e Kompleksitetit:
•	Kompleksiteti Kohor: O(n * b)  
•	Kompleksiteti Hapësinor: O(n * b)  



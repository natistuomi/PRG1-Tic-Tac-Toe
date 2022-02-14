# Planering

## Datastruktur

Jag väljer att använda mig av en lista av listor. Genom
att göra detta gör jag det enklare för mig med skapandet
längre fram eftersom jag kan använda mig av ett koordinatsystem 
vid alla benämningar av specifika rutor. Detta gör i min egen 
åsikt allting mycket smidigare och lättare att hålla reda på. 

## Algoritmbeskrivning

Det finns tre sätt att vinna:
* Horisontellt
* Vertikalt
* Diagonalt

För att se om någon har vunnit måste man därmed checka av 
alla tre möjligheter.

**Horisontellt:**

Alliteration för att minska mängden kod. For-loop där i börjar 
vid 0 och ökar steg för steg tills det inte är mindre än 
antalet rutor i varje led. Sedan undersöker man om alla rutor 
med koordinaterna [ i ][ x ], där x är alla tal som representerar 
rutor, innehåller samma tecken.

**Vertikalt**

Alliteration för att minska mängden kod. For-loop där i börjar
vid 0 och ökar steg för steg tills det inte är mindre än
antalet rutor i varje led. Sedan undersöker man om alla rutor
med koordinaterna [ x ][ i ], där x är alla tal som representerar
rutor, innehåller samma tecken.

**Diagonalt**

Det finns endast två sträckor där man kan vinna diagonalt 
oavsett hur många rutor som finns med i spelet.

Den första har alltid matchande koordinater. Det betyder att 
vi löser det genom att återigen använda en for-loop med samma 
förhållanden och villkor som nämnt ovan och sedan undersöker 
om tecknen i alla rutor med följande koordinater matchar, 
[ i ] [ i ].

Det andra sättet är en aning krångligare. Vi återgår till vår 
for-loop, men använder i det här fallet koordinaterna [ x - i] 
[ i ], där x är antalet rutor i ett led - 1. Detta eftersom 
alla par av koordinater ska ha summan x som är lika med 
antalet rutor i ett led.


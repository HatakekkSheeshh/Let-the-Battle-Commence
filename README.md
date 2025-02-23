# Các biến: 
* CombatScore
* baseHP
* ground
bool exceed =  false; // cannot exceed 999 CombatScore
```cpp
if(Paladin) exceed.Paladin = true;
```

## KNIGHT and WARRIOR:
```cpp
if(Battle's ground: regular number) (là một số chỉ có các thừa số nguyên tố là 2, 3 hoặc 5; N = 2^a + 3^b + 5^c){
    // CombatScore of a Knight or Warriors: based on WP and baseHP
    if(WP == 1){
        CombatScore.Knight = Knight.baseHP;
        CombatScore.Warrior = Warrior.baseHP;
    }
    else{
        CombatScore.Knight = Knight.baseHP / 10.0;
        CombatScore.Warrior = Warrior.baseHP / 10.0;
    }
}
else if(Battle's ground: square number){
    CombatScore of Warrior = 2 * Knight.HP
}
else if(Battle's ground: prime number){
    CombatScore of Warrior = 2 * Warrior.HP;
}
```

## PALADIN
```cpp

if(Paladin in combat){
    CombatScore.Paladin = 3 * baseHP.Paladin;
}
if(baseHP.Paladin: fibo && n > 2){
    CombatScore.Paladin = 1000 + n;
}
```
## DeathEater: no HP, but MP
### MP is a  complex  number C = (real,imaginary)
                                C = a + bi -> C(a,b)
```cpp
CombatScore.DeathEater = sqrt(real*real + imaginary*imaginary);
```    




---
Phương thức static thuộc về class chứ không phải đối tượng cụ thể
Có thể gọi mà không cần tạo instance của class
```java
// Có thể gọi trực tiếp thông qua tên class
Utility.isPrime(5);
Utility.isSquare(4);

// Thay vì phải tạo đối tượng rồi mới gọi
Utility util = new Utility();
util.isPrime(5); // Không cần thiết
```


# Lệnh chạy:  & java -cp class -d bin source/*.java util/*.java






Combatable (Interface)
    ↑
    │    Human (baseHp)
    │     ↓   
    ├── Fighter (baseHp + wp)                (implements Combatable)
    │     ↑
    │     ├── Warrior (kế thừa Fighter)
    │     └── Knight  (kế thừa Fighter)
    │           ↑
    │           └── Paladin (kế thừa Knight)
    │
    └── DeathEater (implements Combatable)


Khi Fighter implements Combatable, tất cả các lớp con của Fighter (Warrior, Knight, Paladin) tự động được kế thừa interface(Combatable) này


Fighter đại diện các chiến binh dùng HP: Warrior, Knight


Human
- baseHp (private trong Human)
- getBaseHp() // getter method

    ↓
Fighter (extends Human)
- mWp (private)
- getWp() // getter method

    ↓
Knight/Warrior (extends Fighter)
- Kế thừa getBaseHp() từ Human
- Kế thừa getWp() từ Fighter







Nếu giá trị duel(sau 2 chiến binh từ đội 1 và đội 2 combat) >= 0.5 và 2 chiến binh đó là đầu tiên:
    -> Qua ground mới
## <span class="c4">Fasada</span>

## <span class="c3">GameModel</span>
, model je fasada
## <span class="c4">View</span>

## <span class="c4">Controller</span>

## <span class="c4">Strategy</span>

<span class="c6">Missile má 2 strategie pohybu: simple a realistic.</span>

<span class="c6">Simple je základní šikmý vrh</span>

<span class="c6">realistická simuluje balistickou křivku</span>

<span class="c6">boomerang simuluje bumerang</span>

<span class="c6">strategie se nastavuje klavesama  1, 2 , 3</span>

## <span class="c4">Proxy</span>

<span class="c0">public class GameModelProxy implements IGameModel</span>

<span class="c0">přístup k modelu ze zbytku aplikace kontrolován pomocí vzoru Proxy</span>

<span class="c0"></span>

## <span class="c4">State</span>

<span class="c6">Cannon bude mít dva stavy:</span>

<span class="c6">single shooting mode</span>

<span class="c6">double shooting mode</span>

<span class="c6">V double shooting modu vystřelí kanon najednou vždy 2 střely, s určitým rozptylem</span>

<span class="c0"></span>

<span class="c0"></span>

## <span class="c4">Visitor</span>

<span class="c6">GraphicsDrawer implements IVisitor</span>

<span class="c6">návrhový vzor Visitor při vykreslování entit (model je nezávislý na View, takže entity neznají metody grafické knihovny)</span>

<span class="c0"></span>

## <span class="c4">Observer</span>

<span class="c3">Model ⇒ View</span>

<span class="c3"></span>

<span class="c3">Observer použitého pro notifikaci Model ⇒ View</span>

<span class="c3"></span>

## <span class="c4">Memento</span>

<span class="c0">AbsGameCommand je memento Caretaker</span>

<span class="c0"></span>

<span class="c0">Memento je využito u commandů, command krok zpět využívá memento k navrácení k předchozímu stavu</span>

<span class="c0"></span>

<span class="c0">Memento na ukládá stav modelu</span>

<span class="c0"></span>

<span class="c0">model vytváří Mementa o stavu hry a aplikuje mementa na model</span>

<span class="c0">kromě modelu nebude mít nikdo možnost Mementa upravit! (zničit uložený stav)</span>

<span class="c0"></span>

## <span class="c4">Command</span>

<span class="c0">objekt ktery pomoci execute spustí konkrétní akci na IGameModel subject</span>

<span class="c0"></span>

<span class="c0">vytváří ho Controller, při vytvoření Commandu se vytvoří memento daného modelu a udloží se</span>

<span class="c0">model ve stepu hodin spracovává comandy</span>

<span class="c0">Existuje command pro krok-zpět, který vezme memento předcházejícího commandu a pomocí něj vrátí hru do předchozího stavu</span>

<span class="c0"></span>

<span class="c0">AbsGameCommand</span>

<span class="c0">MoveCannonDownCommand</span>

<span class="c0">MoveCannonUpCommand</span>

<span class="c0">StopMoveCannonDownCommand</span>

<span class="c0">StopMoveCannonUpCommand</span>

<span class="c0">UndoCommand</span>

## <span class="c4">Abstract factory</span>

<span class="c3">IGameObjectsFactory je abstract Factory, ktera ma 2 typy concrete factory</span>

<span class="c3">realistic mode GameObjectsFactory -> MovingEnemy</span>

<span class="c3">a</span>

<span class="c3">simple mode SimpleGameObjectsFactory -> SimpleEnemy</span>

<span class="c3"></span>

<span class="c3"></span>

## <span class="c4">Singleton</span>

<span class="c3">state, shootingmodes jsou singletony pouziva getInstance()</span>

<span class="c3"></span>

<span class="c3">Decorator</span>

<span class="c3"></span>

## <span class="c4">Unit Testy</span>

<span class="c0">v projektu bude alespoň 5 unit testů (test cases) v alespoň 2 test suitech a bude použito mockování</span>

<span class="c0"></span>

<span class="c0"></span>

<span class="c0"></span>

<span class="c0"></span>

<span class="c0">změna síly střely (force)</span>

<span class="c0">změna úhlu kanónu (angle)</span>

<span class="c0">gravitace (gravity)</span>

<span class="c0">počítání score</span>

<span class="c0">možnost vystřelit více střel najednou (State)</span>

<span class="c0">ovládání modelu pomocí commandů (vzor Command)</span>

<span class="c0">krok-zpět (Memento&Command)</span>

<span class="c0">2 strategie pohybu střely (Strategy)</span>

<span class="c0"></span>

<span class="c0"></span>

-- 코드를 입력하세요
SELECT f.FLAVOR from ICECREAM_INFO i, FIRST_HALF f
    where i.flavor = f.flavor and
    i.INGREDIENT_TYPE = 'fruit_based' and
    f.total_order > 3000
    

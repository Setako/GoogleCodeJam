import           Control.Monad (replicateM)

readWordsLn :: Read a => IO [a]
readWordsLn = map read <$> (words <$> getLine)

readHeadLn :: Read a => IO a
readHeadLn = head <$> readWordsLn

readWordsMultiLn :: Read a => Int -> IO [[a]]
readWordsMultiLn n = replicateM n readWordsLn

main :: IO ()
main = do
  n <- readHeadLn :: IO Int
  inputLines <- replicateM n getLine
  putStrLn $ printCases  1 (fmap solve inputLines)

printCases :: Int -> [(String, String)] -> String
printCases _ [] = ""
printCases i (x:xs) =
  "Case #" ++ show i ++ ": " ++ removeZeros (fst x) ++ " " ++ removeZeros (snd x) ++ "\n" ++ printCases (i + 1) xs

removeZeros :: String -> String
removeZeros ('0':xs) = removeZeros xs
removeZeros xs       = xs

solve :: String -> (String, String)
solve [] = ("", "")
solve (x:xs)
  | x == '4' = ('3' : fst (solve xs), '1' : snd (solve xs))
  | otherwise = (x : fst (solve xs), '0' : snd (solve xs))

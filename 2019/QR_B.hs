import           Control.Monad (replicateM)

readWordsLn :: Read a => IO [a]
readWordsLn = map read <$> (words <$> getLine)

readHeadLn :: Read a => IO a
readHeadLn = head <$> readWordsLn

printCases :: Int -> [String] -> String
printCases _ [] = ""
printCases i (x:xs) = "Case #" ++ show i ++ ": " ++ x ++ "\n" ++ printCases (i + 1) xs

main :: IO ()
main = do
  n <- readHeadLn :: IO Int
  inputLines <- replicateM n (getLine >> getLine)
  putStrLn $ printCases 1 $ fmap solve inputLines

solve :: String -> String
solve []       = []
solve ('E':xs) = 'S' : solve xs
solve ('S':xs) = 'E' : solve xs


<!DOCTYPE html>

<html>

<head>
        <title>import csv</title>
        <meta charset="utf-8" />
        <style>
            #container{
                margin:0 auto;
                width:80%;
                overflow:auto;
            }
            table.gridtable {
                margin:0 auto;
                width:95%;
                font-size:14px;
                color:#111111;
                border-width: 1px;
                border-collapse: collapse;
                text-align: center;
            }
            table.gridtable th {
                border-width: 1px;
                padding: 8px;
                border-style: solid;
                border-color: black;
                background-color:#3366ff;
            }
            table.gridtable td {
                border-width: 1px;
                padding: 8px;
                border-style: solid;
                border-color: black;
            }
            .error {
                color: white;
                background-color: green;
            }
        </style>
</head>

<body>

    <div class="container" id="container">
        <table class="gridtable">
            <thead>
                <tr>
                    <th>column 1</th>
                    <th>column 2</th>

                </tr>
            </thead>
            <tbody>
                <?php
                    if (($csvfile = fopen("input.csv", "r")) !== FALSE) {
                        while (($csvdata = fgetcsv($csvfile, 1111, ",")) !== FALSE) {
                            $error=' ';
                            $colCount = count($csvdata);
                            echo '<tr>';
                            if($colCount!=5) {
                                $error = 'Wrong count';
                            } else {
                                if(!is_numeric($csvdata[0])) $error.='error';
                                $date = date_parse($csvdata[3]);
                                if (!($date["error_count"] == 0 && checkdate($date["month"], $date["day"], $date["year"]))) $Error.='error';
                                
                            }
                            switch($error) {
                                case "Wrong column count :(":
                                    echo '<td class="error" >'.$error.'</td>';
                                   
                                    break;
                                case "error":
                                    echo '<td class="error">'.$csvdata[0].'</td>';
                                    echo '<td class="error">'.$csvdata[1].'</td>';
                                   
                                    break;
                                default:
                                    echo '<td>'.$csvdata[0].'</td>';
                                    echo '<td>'.$csvdata[1].'</td>';

                            }
                            echo '</tr>';
                        }
                        fclose($csvfile);
                    }
                ?>
            </tbody>
           </table>
    </div>

</body>
</html>
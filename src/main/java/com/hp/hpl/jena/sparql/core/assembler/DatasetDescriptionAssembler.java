/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.hpl.jena.sparql.core.assembler;

import java.util.List ;

import com.hp.hpl.jena.assembler.Assembler ;
import com.hp.hpl.jena.assembler.Mode ;
import com.hp.hpl.jena.assembler.assemblers.AssemblerBase ;
import com.hp.hpl.jena.rdf.model.Resource ;
import com.hp.hpl.jena.sparql.core.DatasetDescription ;
import com.hp.hpl.jena.sparql.util.graph.GraphUtils ;

public class DatasetDescriptionAssembler extends AssemblerBase implements Assembler
{
    public DatasetDescriptionAssembler()       {}
    
    public static Resource getType()    { return DatasetAssemblerVocab.tDataset ; }
    
    @Override
    public Object open(Assembler a, Resource root, Mode mode)
    {
        DatasetDescription ds = new DatasetDescription() ;

        // -------- Default graph
        // Can use ja:graph or ja:defaultGraph
        List<String> dftGraphs1 = GraphUtils.multiValueString(root, DatasetAssemblerVocab.pDefaultGraph) ;
        List<String> dftGraphs2 = GraphUtils.multiValueString(root, DatasetAssemblerVocab.pGraph) ;
        ds.getDefaultGraphURIs().addAll(dftGraphs1) ;
        ds.getDefaultGraphURIs().addAll(dftGraphs2) ;

        // -------- Named graphs
        List<String> namedGraphURIs = GraphUtils.multiValueString(root, DatasetAssemblerVocab.pNamedGraph) ; 
        ds.getNamedGraphURIs().addAll(namedGraphURIs) ;
        
        return ds ;
    }
}
